package com.example.learn.activity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

import com.example.learn.R;
import com.example.learn.view.GradientView;
import com.google.ar.core.Anchor;
import com.google.ar.core.Config;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.Session;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.SceneView;
import com.google.ar.sceneform.Sceneform;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.rendering.ViewSizer;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.lang.ref.WeakReference;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainActivity3 extends AppCompatActivity {

    private GradientView backgroundSceneView;
    private SceneView transparentSceneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        backgroundSceneView = findViewById(R.id.backgroundSceneView);

        transparentSceneView = findViewById(R.id.transparentSceneView);
        transparentSceneView.setTransparent(true);
        Handler handler = new Handler(Looper.myLooper());

        loadModels();
        new Thread(() -> {
            int[] colors = {Color.BLUE,Color.YELLOW,Color.RED,Color.BLACK};
            Random random = new Random();
            while (true){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(() ->{
                    backgroundSceneView.setColor(colors[random.nextInt(colors.length)]);
                    backgroundSceneView.postInvalidate();
                });
            }
        }).start();
    }


    @Override
    protected void onResume() {
        super.onResume();
        try {
//            backgroundSceneView.resume();
            transparentSceneView.resume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        backgroundSceneView.pause();
        transparentSceneView.pause();
    }

    public void loadModels() {
//        CompletableFuture<ModelRenderable> dragon = ModelRenderable
//                .builder()
//                .setSource(this, Uri.parse("models/dragon.glb"))
//                .setIsFilamentGltf(true)
//                .setAsyncLoadEnabled(true)
//                .build();
//
//        CompletableFuture<ModelRenderable> backdrop = ModelRenderable
//                .builder()
//                .setSource(this, Uri.parse("models/backdrop.glb"))
//                .setIsFilamentGltf(true)
//                .setAsyncLoadEnabled(true)
//                .build();
//
//        LinearLayout linearLayout = new LinearLayout(MainActivity3.this);
//        LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(50,10);
//        linearLayout.setLayoutParams(lllp);
//        linearLayout.setBackgroundColor(Color.RED);
//
//        GradientView gradientView = new GradientView(MainActivity3.this);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        gradientView.setLayoutParams(layoutParams);
//
//        CompletableFuture<ViewRenderable> viewRenderble =  ViewRenderable
//                .builder()
//                .setView(this,  new GradientView(MainActivity3.this))
//                .setSizer(view -> new Vector3(1f, 1f, 1f))
//                .build();
//
//        CompletableFuture.allOf(dragon, backdrop,viewRenderble)
//                .handle((ok, ex) -> {
//                    try {
//                        Node modelNode1 = new Node();
//                        modelNode1.setRenderable(viewRenderble.get());
//                        //缩放、默认250像素
//                        modelNode1.setLocalScale(new Vector3(3f, 1f, 1f));
//                        //旋转：前后、左右、上下
//                        modelNode1.setLocalRotation(Quaternion.axisAngle(new Vector3(-1f, 0f, 0f), 90));
//                        //位置：0:0:0为手机屏幕中点。x左右、y上下、z前后
//                        modelNode1.setLocalPosition(new Vector3(0f, -1.0f, -1f));
//                        backgroundSceneView.getScene().addChild(modelNode1);
//////
////                        Node modelNode2 = new Node();
////                        modelNode2.setRenderable(backdrop.get());
////                        modelNode2.setLocalScale(new Vector3(0.3f, 0.3f, 0.3f));
////                        modelNode2.setLocalRotation(Quaternion.multiply(
////                                Quaternion.axisAngle(new Vector3(1f, 0f, 0f), 45),
////                                Quaternion.axisAngle(new Vector3(0f, 1f, 0f), 75)));
////                        modelNode2.setLocalPosition(new Vector3(0f, 0f, -1.0f));
////                        backgroundSceneView.getScene().addChild(modelNode2);
//
//                        Node modelNode3 = new Node();
//                        modelNode3.setRenderable(dragon.get());
//
//                        //缩放、默认250像素
//                        modelNode3.setLocalScale(new Vector3(0.3f, 0.3f, 0.3f));
//                        //旋转：前后、左右、上下
//                        modelNode3.setLocalRotation(Quaternion.axisAngle(new Vector3(0f, 1f, 0f), 35));
//                        //位置：0:0:0为手机屏幕中点。x左右、y上下、z前后
//                        modelNode3.setLocalPosition(new Vector3(0f, 0f, -1f));
//                        backgroundSceneView.getScene().addChild(modelNode3);
//
////                        Node modelNode4 = new Node();
////                        modelNode4.setRenderable(backdrop.get());
////                        modelNode4.setLocalScale(new Vector3(0.3f, 0.3f, 0.3f));
////                        modelNode4.setLocalRotation(Quaternion.axisAngle(new Vector3(0f, 1f, 0f), 35));
////                        modelNode4.setLocalPosition(new Vector3(0f, 0f, -1.0f));
////                        transparentSceneView.getScene().addChild(modelNode4);
//                    } catch (InterruptedException | ExecutionException ignore) {
//
//                    }
//                    return null;
//                });
    }
}
