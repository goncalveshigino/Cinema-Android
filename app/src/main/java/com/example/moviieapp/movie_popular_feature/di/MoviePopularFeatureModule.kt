package com.example.moviieapp.movie_popular_feature.di

import com.example.moviieapp.core.data.remote.MovieService
import com.example.moviieapp.movie_popular_feature.data.repository.MoviePopularRepositoryImpl
import com.example.moviieapp.movie_popular_feature.data.source.MoviePopularRemoteDataSourceImp
import com.example.moviieapp.movie_popular_feature.domain.repository.MoviePopularRepository
import com.example.moviieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import com.example.moviieapp.movie_popular_feature.domain.usecase.GetPopularMoviesUseCase
import com.example.moviieapp.movie_popular_feature.domain.usecase.GetPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MoviePopularFeatureModule {


    @Provides
    @Singleton
    fun provideMovieDataSource(service: MovieService):  MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImp(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: MoviePopularRemoteDataSource): MoviePopularRepository {
        return MoviePopularRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(repository: MoviePopularRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCaseImpl(repository = repository)
    }

}