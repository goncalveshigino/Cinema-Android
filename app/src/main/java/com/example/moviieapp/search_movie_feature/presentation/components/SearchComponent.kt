package com.example.moviieapp.search_movie_feature.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviieapp.R
import com.example.moviieapp.search_movie_feature.presentation.MovieSearchEvents
import com.example.moviieapp.ui.theme.black
import com.example.moviieapp.ui.theme.white
import com.example.moviieapp.ui.theme.yellow

@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    query: String,
    onSearch: (String) -> Unit,
    onQueryChangeEvent: (MovieSearchEvents) -> Unit,
) {
    OutlinedTextField(
        value = query,
        onValueChange = {
            onQueryChangeEvent(MovieSearchEvents.EnteredQuery(it))
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    onSearch(query)
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = white
                )
            }
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_movies),
                color = white
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Sentences,
            autoCorrectEnabled = true,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(query)
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = white,
            focusedIndicatorColor = yellow,
            unfocusedIndicatorColor = black,
            cursorColor = white
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp)
    )
}

@Preview
@Composable
private fun SearchComponentPreview() {
    SearchComponent(
        query = "",
        onSearch = {},
        onQueryChangeEvent = {}
    )
}