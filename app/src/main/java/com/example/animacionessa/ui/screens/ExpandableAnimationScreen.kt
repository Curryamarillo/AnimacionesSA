package com.example.animacionessa.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.animacionessa.R
import com.example.animacionessa.ui.theme.splash

@Composable
fun ExpandableAnimationScreen() {

    var expanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 21.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(12.dp))
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Tombstone blues",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = MaterialTheme.splash.ring3)

            }
            Text(
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp,
                text = "Bob Dylan (Highway 61 Revisited), 1968")
            TextButton(
                onClick = {expanded = !expanded}) {
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    fontSize = 18.sp,
                    text = if (expanded) "Menos." else "Leer más...",
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Justify,
                    text = "Well, the sweet pretty things are in bed now, of course\n" +
                            "City fathers they're trying to endorse\n" +
                            "The reincarnation of Paul Revere's horse\n" +
                            "But the town has no need to be nervous\n" +
                            "The ghost of Belle Starr, she hands down her wits\n" +
                            "To Jezebel the nun, she violently knits\n" +
                            "A bald wig for Jack the ripper, who sits\n" +
                            "At the head of the Chamber of Commerce\n" +
                            "Mama's in the factory\n" +
                            "She ain't got no shoes\n" +
                            "Daddy's in the alley lookin' for the fuse\n" +
                            "I'm in the kitchen with the tombstone blues\n" +
                            "The hysterical bride in the penny arcade\n" +
                            "Screaming, she moans, \"I've just been made\"\n" +
                            "Sends for the doctor, who pulls down the shade\n" +
                            "Say my advice is to not let the boys in\n" +
                            "Now, the medicine man comes and he shuffles inside\n" +
                            "He walks with a swagger, and he says to the bride\n" +
                            "\"Stop all this weeping, swallow your pride\n" +
                            "You won't die, it's not poison\"\n" +
                            "Mama's in the factory\n" +
                            "She ain't got no shoes\n" +
                            "Daddy's in the alley lookin' for the fuse\n" +
                            "I'm in the kitchen with the tombstone blues\n" +
                            "John the Baptist, after torturing a thief\n" +
                            "Looks up at his hero, the Commander-in-Chief\n" +
                            "Saying, \"Tell me, great hero, but please, make it brief\n" +
                            "Is there a hole for me to get sick in?\"\n" +
                            "The Commander-in-Chief answers him while chasing a fly\n" +
                            "Saying, \"Death to all those who would whimper and cry\"\n" +
                            "And dropping a barbell, he points to the sky\n" +
                            "Saying, \"The sun's not yellow, it's chicken\"\n" +
                            "Mama's in the factory\n" +
                            "She ain't got no shoes\n" +
                            "Daddy's in the alley lookin' for the fuse\n" +
                            "I'm in the kitchen with the tombstone blues\n" +
                            "The geometry of innocent flesh on the bone\n" +
                            "Causes Galileo's maths book to get thrown\n" +
                            "At Delilah who's sitting worthlessly alone\n" +
                            "But the tears on her cheeks are from laughter\n" +
                            "I wish I could give Brother Bill his great thrill\n" +
                            "I've set him in chains at the top of the hill\n" +
                            "Send them out for some pillars and Cecil B. DeMille\n" +
                            "He could die happily ever after\n" +
                            "Mama's in the factory\n" +
                            "She ain't got no shoes\n" +
                            "Daddy's in the alley lookin' for the fuse\n" +
                            "I'm in the kitchen with the tombstone blues\n" +
                            "Where Ba Rainey and Beethoven once unwrapped their bedroll\n" +
                            "Tuba players now, rehearse around the flagpole\n" +
                            "And the National Bank at a profit sells road maps for the soul\n" +
                            "To the old folks home and the college\n" +
                            "I wish I could write you a melody so plain\n" +
                            "That could hold you dear lady from going insane\n" +
                            "That can ease you, cool you, and cease the pain\n" +
                            "Of your useless and pointless knowledge\n" +
                            "Mama's in the factory\n" +
                            "She ain't got no shoes\n" +
                            "Daddy's in the alley lookin' for the fuse\n" +
                            "I'm in the kitchen with the tombstone blues\n"
                )
            }
        }
    }

}