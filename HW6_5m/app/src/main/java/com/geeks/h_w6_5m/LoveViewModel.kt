package com.geeks.h_w6_5m
import androidx.lifecycle.ViewModel
import androidx.room.Dao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel

class LoveViewModel @Inject constructor(
    private val loveDao: LoveDao
):ViewModel(){
    private val ioScope: CoroutineScope =  CoroutineScope(Dispatchers.IO)
  fun insertLove(love:LoveEntity){
      ioScope.launch{
          loveDao.insertLove(love)
      }
  }
fun deleteLove(love: LoveEntity){
    ioScope.launch {
        loveDao.deleteLove(love)
    }
}
    suspend fun getAllLove():List<LoveEntity>{
        return loveDao.getAllLove()
    }

}