package me.abraham.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    val sensorManager: SensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
    lateinit var textView : TextView

    override fun onSensorChanged(event: SensorEvent?) {
        textView.text = "x = ${event!!.values[0]} \n\n" + "y = ${event.values[1]}\n\n" + "z = ${event.values[2]}"
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.accelerometer_data)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(
                this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL
        )
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    }


}
