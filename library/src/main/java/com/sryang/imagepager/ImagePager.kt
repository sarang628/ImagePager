package com.sryang.imagepager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.sryang.library.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagePager(
    list: List<String>,
    position: Int = 0,
    image: @Composable (String) -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = {
        list.size
    })

    LaunchedEffect(key1 = position) {
        pagerState.scrollToPage(position)
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        constraintSet = imagePagerConstraintSet()
    ) {
        Scaffold(
            Modifier
                .fillMaxSize(),
            containerColor = Color.Transparent

        ) {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color.Transparent),
            ) {

                HorizontalPager(
                    modifier = Modifier.align(Alignment.Center),
                    state = pagerState
                ) {
                    image.invoke(list[it])
                }

                Column(modifier = Modifier.align(Alignment.BottomStart).padding(start = 12.dp, end = 12.dp)) {
                    Text(
                        modifier = Modifier.layoutId("name"),
                        text = "Torang", color = Color.White, fontWeight = FontWeight.Bold
                    )

                    Text(
                        modifier = Modifier.layoutId("contents"),
                        text = "Contents", color = Color.White, fontSize = 12.sp
                    )

                    Text(
                        modifier = Modifier.layoutId("date"),
                        text = "MAY 10 AT 6:40 PM", color = Color.LightGray, fontSize = 12.sp
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                modifier = Modifier.size(15.dp),
                                painter = painterResource(id = R.drawable.heart_filled),
                                contentDescription = "",
                                tint = Color.Red
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(text = "1.7K", color = Color.White, fontSize = 12.sp)
                        }
                        Text(
                            text = "762 comments",
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterEnd), fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

fun imagePagerConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val imagePager = createRefFor("imagePager")
        val name = createRefFor("name")
        val date = createRefFor("date")
        val contents = createRefFor("contents")

        constrain(imagePager) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }

        constrain(contents) {
            top.linkTo(name.bottom)
        }

        constrain(date) {
            top.linkTo(contents.bottom)
        }
    }
}

@Preview
@Composable
fun PreviewImagePager() {
    ImagePager(list = listOf()) {

    }
}