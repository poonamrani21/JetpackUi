package com.example.jetpacknavgraph.screens.user_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpacknavgraph.helper.DRAWABLE
import com.example.jetpacknavgraph.helper.asPainter
import com.example.jetpacknavgraph.model.TabItem
import com.example.jetpacknavgraph.ui.theme.compose_view.NoRippleTab
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@ExperimentalPagerApi
@OptIn(ExperimentalPagerApi::class)
@ExperimentalComposeUiApi
@Composable
fun  UserProfileScreen(controller: NavController,openDrawer: () -> Unit){
    val tabs = listOf(
        TabItem.Grid,
        TabItem.IGTV,
        TabItem.Mention
    )
  val pagerState = rememberPagerState(tabs.size)

    TopBar(name = "Poonam Rani")
    CollapsingToolbarScaffold(
        modifier = Modifier.fillMaxWidth().padding(top = 64.dp),
        state = rememberCollapsingToolbarScaffoldState(),
        scrollStrategy = ScrollStrategy.EnterAlwaysCollapsed,
        toolbar = {
            Box(modifier = Modifier.pin())
            Column(modifier = Modifier.road(whenCollapsed = Alignment.BottomStart, whenExpanded = Alignment.BottomEnd)) {
                ProfileSection()
                Spacer(modifier = Modifier.height(25.dp))
               // ButtonSection(modifier = Modifier.fillMaxWidth())
               // Spacer(modifier = Modifier.height(25.dp))
             /*   HighlightSection(
                    highlights = listOf(
                       *//* StoryHighlight(image = DRAWABLE.ic_back_icon.asPainter(), title = "Projects"),
                        StoryHighlight(image = DRAWABLE.ic_back_icon.asPainter(), title = "Art"),
                        StoryHighlight(image = DRAWABLE.ic_back_icon.asPainter(), title = "My wOrDs"),
                        StoryHighlight(image = DRAWABLE.ic_back_icon.asPainter(), title = "Coffee"),*//*
                    ),
                    modifier = Modifier.fillMaxWidth()
                )*/
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    ) {
        Column {
            TabView(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}

@Composable
private fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Icon(
            painter = DRAWABLE.ic_back_icon.asPainter(),
            contentDescription = "Back",
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .weight(0.17F)
                .size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colors.onBackground,
            maxLines = 1,
            modifier = Modifier
                .padding(start = 4.dp, end = 16.dp)
                .weight(0.58F)
        )
        Icon(
            painter = DRAWABLE.ic_back_icon.asPainter(),
            contentDescription = "Bell",
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .size(24.dp)
                .weight(0.08F)
        )
        Icon(
            painter = DRAWABLE.ic_back_icon.asPainter(),
            contentDescription = "Menu",
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .weight(0.17F)
                .size(18.dp)
        )
    }
}

@Composable
private fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp)
        ) {
            RoundImage(image = DRAWABLE.ic_back_icon.asPainter(), modifier = Modifier.size(90.dp).weight(3F))
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7F))
        }
        Spacer(modifier = Modifier.height(12.dp))
        ProfileDescription(
            displayName = "Poonam Rani",
            description = "Android Developer \uD83D\uDCBB\uD83D\uDCF1\n" + "Test \uD83C\uDFA5\uD83D\uDCD6\uD83C\uDFA8\n",
            followedBy = listOf("You"),
            otherCount = 26
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1F, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
private fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(value = "9", title = "Posts")
        ProfileStat(value = "349", title = "Followers")
        ProfileStat(value = "303", title = "Following")
    }
}

@Composable
private fun ProfileStat(
    value: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            fontSize = 14.sp,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
private fun ProfileDescription(
    displayName: String,
    description: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = displayName,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            color = MaterialTheme.colors.primary,
            fontSize = 14.sp,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()) {
            Text(
                color = MaterialTheme.colors.onBackground,
                fontSize = 14.sp,
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Bold,
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
private fun ButtonSection(modifier: Modifier = Modifier) {
    var isLoading by remember { mutableStateOf(false) }
    val height = 35.dp

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        ActionButton(
            text = "Following",
            textColor = Color(0xFF14B31B),
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .weight(1F)
                .height(height = height)
        ) {}
        ActionButton(
            text = "Message",
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1F)
                .height(height = height)
        ) {}
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .padding(start = 8.dp)
                .height(height = height),
            isLoading = isLoading
        ) {
            isLoading = !isLoading
        }
    }
}


@Composable
private fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    textColor: Color = MaterialTheme.colors.onBackground,
    icon: ImageVector? = null,
    isLoading: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
       /* if (!isLoading) {
            text.ifNotNull {
                Text(
                    text = "Dummy",
                    color = textColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                )
            }
            icon.ifNotNull {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onBackground,
                )
            }
        } else {
            CircularIndeterminateProgressBar(
                modifier = Modifier
                    .size(23.dp)
                    .padding(2.dp),
                color = MaterialTheme.colors.onBackground,
                strokeWidth = 2.dp
            )
        }*/
    }
}
/*

@Composable
private fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlight>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(
                    start = 15.dp,
                    end = if (it == highlights.size - 1) 15.dp else 0.dp
                )
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = highlights[it].title,
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
*/

@ExperimentalPagerApi
@Composable
private fun TabView(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    val inactiveColor = Color(0xFF777777)
    val activeColor = MaterialTheme.colors.onBackground

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        contentColor = activeColor,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(
                    pagerState = pagerState,
                    tabPositions = tabPositions
                )
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            NoRippleTab(
                selected = pagerState.currentPage == index,
                selectedContentColor = activeColor,
                unselectedContentColor = inactiveColor,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            ) {
                Icon(
                    painter = tab.icon.asPainter(),
                    contentDescription = tab.title,
                    tint = if (pagerState.currentPage == index) activeColor else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(22.dp)
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(tabs.size,state = pagerState) { page ->
        tabs[page].screen()
    }

}