package id.rizmaulana.instaclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import id.rizmaulana.instaclone.ui.theme.InstaCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InstaClone()
                }
            }
        }
    }
}

@Composable
fun InstaClone() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AppBar()
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            (0..10).forEach { _ ->
                StoryItem()
            }
        }
        (0..5).forEach {
            PostSection()
        }
    }
}

@Composable
fun AppBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "InstaClone",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Icon(imageVector = Icons.Outlined.Add, contentDescription = null)
        Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
        Icon(imageVector = Icons.Outlined.MailOutline, contentDescription = null)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun StoryItem() {
    Column(
        modifier = Modifier.padding(horizontal = 6.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .border(4.dp, MaterialTheme.colors.primary, shape = CircleShape)
                .size(68.dp),
        ) {
            GlideImage(
                model = "https://pbs.twimg.com/media/Dt7QEdcWsAIaSOG.jpg",
                contentDescription = null
            )
        }

        Text(text = "leo.messi", style = MaterialTheme.typography.caption, fontSize = 10.sp)

    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PostSection() {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .border(2.dp, MaterialTheme.colors.primary, shape = CircleShape)
                    .size(48.dp),
            ) {
                GlideImage(
                    model = "https://pbs.twimg.com/profile_images/791906337491787776/phTGStBZ_400x400.jpg",
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.weight(1f),
                text = "Marvel",
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Bold
            )
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
        }

        GlideImage(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxSize(),
            model = "https://images.bisnis.com/posts/2022/09/24/1580873/loki-season-2.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null
            )
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_comment),
                contentDescription = null
            )
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_send),

                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = null
            )
        }

        Text(
            modifier =  Modifier.padding(horizontal = 12.dp),
            text = "Liked by leo.messi", style = MaterialTheme.typography.caption,
        )
        Text(
            modifier =  Modifier.padding(horizontal = 12.dp),
            text = "marvel marvel Start your countdown to the glorious arrival of Marvel Studios",
            style = MaterialTheme.typography.caption,
        )


    }
}

