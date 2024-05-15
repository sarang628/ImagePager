package com.sryang.imagepager

import TorangAsyncImage
import ZoomableTorangAsyncImage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sryang.imagepager.ui.theme.ImagePagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImagePagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ImagePager(
                            list = listOf(
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/09_19_29_616.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/09_19_29_653.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/09_30_07_284.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/09_30_07_325.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/09_59_45_505.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/09_59_45_535.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/10_12_56_409.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/10_12_56_453.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/10_14_24_779.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/10_14_41_930.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/10_45_42_899.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/10_45_42_943.jpg",
                                "http://sarang628.iptime.org:89/review_images/0/0/2023-09-14/10_45_43_007.jpg"
                                ),
                            position = 5
                        ) { url ->
                            ZoomableTorangAsyncImage(
                                model = url,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}
