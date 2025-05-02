package com.sakaltj.petobject.client;

import com.sakalti.petobject.client.model.LumeiModel;
import com.sakalti.petobject.client.renderer.LumeiRenderer;
import com.sakalti.petobject.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.EntityRendererRegistry;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelLoader;

public class PetObjectClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityRegistry.LUMEI, LumeiRenderer::new);
        Entitypackage com.sakalti.petobject.client;

import com.sakalti.petobject.client.model.MechanylModel;
import com.sakalti.petobject.client.renderer.MechanylRenderer;
import com.sakalti.petobject.client.model.LumeiModel;
import com.sakalti.petobject.client.renderer.LumeiRenderer;
import com.sakalti.petobject.entity.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.model.ModelPartBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.util.Identifier;

public class PetObjectClient implements ClientModInitializer {
    public static final Identifier MECHANYL_TEXTURE = new Identifier("petobject", "textures/entity/mechanyl.png");
    public static final Identifier LUMEI_TEXTURE = new Identifier("petobject", "textures/entity/lumei.png");

    @Override
    public void onInitializeClient() {
        // メカニルのモデルレイヤーを登録
        EntityModelLayerRegistry.registerModelLayer(MechanylModel.LAYER, MechanylModel::getTexturedModelData);
        // メカニルのレンダラーを登録
        EntityRendererRegistry.register(EntityRegistry.MECHANYL, MechanylRenderer::new);

        // ルーメイのモデルレイヤーを登録
        EntityModelLayerRegistry.registerModelLayer(LumeiModel.LAYER, LumeiModel::getTexturedModelData);
        // ルーメイのレンダラーを登録
        EntityRendererRegistry.register(EntityRegistry.LUMEI, LumeiRenderer::new);

        // モデルやテクスチャのロード処理
        ModelLoadingRegistry.INSTANCE.registerAppender((manager, out) -> {
            // 必要に応じてモデルの登録処理を追加
        });
    }
}
