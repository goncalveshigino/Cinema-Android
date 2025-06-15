package com.example.moviieapp.core.page


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviieapp.core.domain.model.Movie
import com.example.moviieapp.movie_popular_feature.data.mapper.toMovie
import com.example.moviieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource constructor(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {

            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getPopularMovies(page = pageNumber)
            val movies = response.results

            LoadResult.Page(
                data = movies.toMovie(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (movies.isEmpty()) null else pageNumber + 1
            )

        } catch(exception: IOException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val LIMIT = 20
    }
}