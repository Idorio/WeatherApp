package com.example.weatherapp.data


import com.example.weatherapp.data.database.dao.WeatherDAO
import com.example.weatherapp.data.service.ApiService
import com.example.weatherapp.domain.WeatherRepository
import com.example.weatherapp.domain.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val weatherDAO: WeatherDAO
) : WeatherRepository {
     override suspend fun getWeather(city: String): Response<WeatherModel> {
         return withContext(Dispatchers.IO) {
             apiService.getWeather(city, "7ffea88483fb4e648a360906232403", 4)
         }
     }
    override suspend fun showWeather(): List<WeatherModel> {
        TODO("Not yet implemented")
    }
}
//verride suspend fun getData() {
//    return withContext(Dispatchers.IO) {
//
//        if (!itemsDAO.doesItemsEntityExist()) {
//            Log.w("getData", "data not exists")
//            val response = apiService.getData()
//            Log.w("data", response.body()?.sampleList.toString())
//            response.body()?.sampleList?.let {
//                it.map {
//                    val itemsEntity =
//                        ItemsEntity(Random().nextInt(), it.description, it.imageUrl)
//                    itemsDAO.insertItemsEntity(itemsEntity)
//
//                }
//            }
//        }
//
//    }
//}
//
//override suspend fun showData(): List<ItemsModel> {
//    return withContext(Dispatchers.IO) {
//        val itemsEntity = itemsDAO.getItemsEntities()
//        itemsEntity.map {
//            ItemsModel(it.description, it.imageUrl)
//        }
//    }
//}
