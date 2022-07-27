package com.admissions.ionixapp.di

import android.app.Application
import androidx.room.Room
import com.admissions.ionixapp.common.RoomDatabaseName
import com.admissions.ionixapp.data.MoviesRepository
import com.admissions.ionixapp.data.database.MovieDao
import com.admissions.ionixapp.data.database.MovieDataBase
import com.admissions.ionixapp.data.database.MovieRoomDataBase
import com.admissions.ionixapp.data.datasource.MovieRemoteDataSource
import com.admissions.ionixapp.data.server.MovieServerDataSource
import com.admissions.ionixapp.ui.common.LocationHelper
import com.admissions.ionixapp.usecases.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) = Room.databaseBuilder(
        app,
        MovieDataBase::class.java,
        RoomDatabaseName
    ).build()

    @Provides
    fun locationHelperProvider(app : Application) = LocationHelper(app)

    @Provides
    fun moviesRemoteDataSource(locationHelper: LocationHelper): MovieRemoteDataSource = MovieServerDataSource(locationHelper)

    @Provides
    @Singleton
    fun movieDaoProvider(db: MovieDataBase) = db.movieDao()

    @Provides
    fun localDataSource(movieDao: MovieDao) = MovieRoomDataBase(movieDao)
}

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun moviesRepositoryProvider(localDataSource: MovieRoomDataBase, remoteDataSource: MovieRemoteDataSource) = MoviesRepository(localDataSource, remoteDataSource)
}

@Module
@InstallIn(ViewModelComponent::class)
class GeneralModule {

    @Provides
    fun userUseCasesProvider(repository: MoviesRepository): GetPopularMoviesUseCase = GetPopularMoviesUseCase(repository)
}