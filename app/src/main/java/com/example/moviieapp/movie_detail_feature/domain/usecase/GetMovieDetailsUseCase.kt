package com.example.moviieapp.movie_detail_feature.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import coil.network.HttpException
import com.example.moviieapp.core.domain.model.Movie
import com.example.moviieapp.core.domain.model.MovieDateils
import com.example.moviieapp.core.util.ResultData
import com.example.moviieapp.movie_detail_feature.domain.repository.MovieDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import java.io.IOException
import javax.inject.Inject


interface GetMovieDetailsUseCase {
    operator fun invoke(params: Params): Flow<ResultData<Pair<Flow<PagingData<Movie>>, MovieDateils>>>
    data class Params(val movieId: Int)
}

class GetMovieDetailsUseCaseImpl @Inject constructor(
    private val repository: MovieDetailsRepository
): GetMovieDetailsUseCase {
    override fun invoke(params: GetMovieDetailsUseCase.Params): Flow<ResultData<Pair<Flow<PagingData<Movie>>, MovieDateils>>> {
       return flow {
           try {
               emit(ResultData.Loading)

               val movieDetails = repository.getMovieDetails(params.movieId)
               val moviesSimilar =  repository.getMovieSimilar(
                   movieId =  params.movieId,
                   pagingConfig = PagingConfig(
                       pageSize = 20,
                       initialLoadSize = 20
                   )
               )

               emit(ResultData.success(moviesSimilar to movieDetails))
           } catch (e: HttpException) {
                emit(ResultData.Failure(e))
           } catch(e: IOException) {
               emit(ResultData.Failure(e))
           }
       }.flowOn(Dispatchers.IO)
    }
}