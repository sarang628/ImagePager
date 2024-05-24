package com.sryang.imagepager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.snapshotFlow
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
    onPage: ((Int) -> Unit)? = null,
    image: @Composable (String) -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = {
        list.size
    })

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow {
            pagerState.currentPage
        }.collect { position ->
            onPage?.invoke(position)
        }
    }

    LaunchedEffect(key1 = position) {
        pagerState.scrollToPage(position)
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
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

            }
        }
    }
}

@Preview
@Composable
fun PreviewImagePager() {
    ImagePager(
        list = listOf(),
        position = 0,
        image = { },
    )
}