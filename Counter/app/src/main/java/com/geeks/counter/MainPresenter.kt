package com.geeks.counter

import android.graphics.Color

class MainPresenter {
    private val model = CounterModel()
    private var contract: CounterContract? = null
    fun attachContract(contract: CounterContract){
        this.contract = contract
        contract.showResult(model.count)
    }
    fun onIncrement(){
        model.increment()
        checkCount()
        contract?.showResult(model.count)
    }
    fun onDecrement(){
        model.decrement()
        checkCount()
        contract?.showResult(model.count)
    }
    private fun checkCount(){

        when(model.count){
            15-> contract?.changeColor(Color.GREEN)
            10-> contract?.showToast("Поздравляем")
        }
    }


    fun detachContract(){
        contract = null
    }
}