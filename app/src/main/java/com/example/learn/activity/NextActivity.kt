package com.example.learn.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.learn.R
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.rendering.ViewRenderable
import com.gorisse.thomas.sceneform.scene.await

class NextActivity : AppCompatActivity() {

    private var model: Renderable? = null
    private var modelView: ViewRenderable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        initView()

        lifecycleScope.launchWhenCreated {
            loadModels()
        }
    }

    private suspend fun loadModels(){
        model = ModelRenderable.builder()
            .setSource(this, Uri.parse("models/halloween.glb"))
            .setIsFilamentGltf(true)
            .await()
        modelView = ViewRenderable.builder()
            .setView(this, R.layout.view_renderable_infos)
            .await()
    }

    private fun initView() {
    }
}