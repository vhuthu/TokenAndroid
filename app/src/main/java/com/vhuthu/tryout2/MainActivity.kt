package com.vhuthu.tryout2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.vhuthu.tryout2.ui.theme.TryOut2Theme
import com.vhuthu.tryout2.utils.ApiState
import com.vhuthu.tryout2.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TryOut2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                 ) {

                    lifecycleScope.launchWhenStarted {
                        viewModel.data.collect {
                            when(it){
                                is ApiState.Success -> {
                                  //  Log.d("Token", it.data!!.toString())
                                    val body = it.data.toString()

//                                    Log.d(Tag,response.)

                                }

                                is ApiState.Failaure ->{
                                Log.e("error", it.msg)
                                }

                                is ApiState.Loading ->{

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
