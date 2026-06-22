package com.romchik.chickenburger.client.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.player.PlayerEntity;

public class ChickenModel extends EntityModel<PlayerEntity> {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer leftWing;
    public ModelRenderer rightWing;
    public ModelRenderer leftLeg;
    public ModelRenderer rightLeg;
    public ModelRenderer tail;

    public ChickenModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        // Body
        this.body = new ModelRenderer(this);
        this.body.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.body.addBox(-2.5F, -2.0F, -3.0F, 5.0F, 5.0F, 6.0F, 0.0F);

        // Head
        this.head = new ModelRenderer(this);
        this.head.setRotationPoint(0.0F, 13.0F, -3.0F);
        this.head.addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 3.0F, 0.0F);

        // Left Wing
        this.leftWing = new ModelRenderer(this);
        this.leftWing.setRotationPoint(2.5F, 15.5F, 0.0F);
        this.leftWing.addBox(0.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F);

        // Right Wing
        this.rightWing = new ModelRenderer(this);
        this.rightWing.setRotationPoint(-2.5F, 15.5F, 0.0F);
        this.rightWing.addBox(-2.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F);

        // Left Leg
        this.leftLeg = new ModelRenderer(this);
        this.leftLeg.setRotationPoint(1.5F, 20.0F, 0.0F);
        this.leftLeg.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F);

        // Right Leg
        this.rightLeg = new ModelRenderer(this);
        this.rightLeg.setRotationPoint(-1.5F, 20.0F, 0.0F);
        this.rightLeg.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F);

        // Tail
        this.tail = new ModelRenderer(this);
        this.tail.setRotationPoint(0.0F, 16.0F, 3.0F);
        this.tail.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F);
    }

    @Override
    public void render(com.mojang.blaze3d.matrix.MatrixStack matrixStack, net.minecraft.client.renderer.IRenderTypeBuffer buffer, int packedLight, int packedOverlay, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        matrixStack.push();
        matrixStack.scale(0.6F, 0.6F, 0.6F);

        this.body.render(matrixStack, buffer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        this.head.render(matrixStack, buffer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        this.leftWing.render(matrixStack, buffer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        this.rightWing.render(matrixStack, buffer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        this.leftLeg.render(matrixStack, buffer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        this.rightLeg.render(matrixStack, buffer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        this.tail.render(matrixStack, buffer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStack.pop();
    }

    @Override
    public void setLivingAnimations(PlayerEntity entity, float limbSwing, float limbSwingAmount, float partialTick) {
        // Wing flapping animation
        this.leftWing.rotateAngleZ = (float) Math.sin(limbSwing * 0.6F) * 0.5F;
        this.rightWing.rotateAngleZ = -(float) Math.sin(limbSwing * 0.6F) * 0.5F;

        // Leg walking animation
        this.leftLeg.rotateAngleX = (float) Math.cos(limbSwing * 0.6F) * limbSwingAmount;
        this.rightLeg.rotateAngleX = -(float) Math.cos(limbSwing * 0.6F) * limbSwingAmount;
    }
}
