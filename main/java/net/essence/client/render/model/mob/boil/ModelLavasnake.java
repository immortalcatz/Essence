package net.essence.client.render.model.mob.boil;

import org.lwjgl.opengl.GL11;

import net.essence.entity.mob.boiling.EntityLavasnake;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLavasnake extends ModelBiped {

    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer headFin;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer fin1;
    ModelRenderer fin2;
    ModelRenderer fin3;
    ModelRenderer tailFin;
    ModelRenderer mouth;
    ModelRenderer tooth1;
    ModelRenderer tooth2;

    public int textureWidth = 128;
    public int textureHeight = 128;
    
    protected double distanceMovedTotal = 0.0D;
    protected static final double CYCLES_PER_BLOCK = 3.0D; 
    protected int cycleIndex = 0;
    protected float[][] undulationCycle = new float[][]
    		
    	{
            { 45F, -45F, -45F, 0F, 45F, 45F, 0F, -45F },
            { 0F, 45F, -45F, -45F, 0F, 45F, 45F, 0F },
            { -45F, 90F, 0F, -45F, -45F, 0F, 45F, 45F },
            { -45F, 45F, 45F, 0F, -45F, -45F, 0F, 45F },
            { 0F, -45F, 45F, 45F, 0F, -45F, -45F, 0F },
            { 45F, -90F, 0F, 45F, 45F, 0F, -45F, -45F },
        };
    
	public ModelLavasnake() {
	    
	      head = new ModelRenderer(this, 54, 0);
	      head.addBox(-4F, -4F, -6F, 8, 6, 6);
	      head.setRotationPoint(0F, 8F, -8F);
	      head.setTextureSize(128, 128);
	      setRotation(head, 0F, 0F, 0F);
	      
	      body = new ModelRenderer(this, 52, 32);
	      body.addBox(-6F, -10F, -7F, 12, 18, 12);
	      body.setRotationPoint(0F, 7F, 2F);
	      body.setTextureSize(128, 128);
	      setRotation(body, 1.570796F, 0F, 0F);
	      
	      headFin = new ModelRenderer(this, 0, 24);
	      headFin.addBox(0F, 0F, 0F, 0, 6, 8);
	      headFin.setRotationPoint(0F, 2F, -16F);
	      headFin.setTextureSize(128, 128);
	      setRotation(headFin, 0.2974289F, 0F, 0F);
	      
	      body1 = new ModelRenderer(this, 18, 15);
	      body1.addBox(-5F, 0F, 0F, 10, 16, 10);
	      body1.setRotationPoint(0F, 13F, 10F);
	      body1.setTextureSize(128, 128);
	      setRotation(body1, 1.570796F, 0F, 0F);
	      
	      body2 = new ModelRenderer(this, 18, 60);
	      body2.addBox(-4F, 16F, 1F, 8, 14, 7);
	      body2.setRotationPoint(0F, 13F, 10F);
	      body2.setTextureSize(128, 128);
	      body1.addChild(body2);
	      setRotation(body2, 0F, undulationCycle[0][0], 0F);
	      
	      body3 = new ModelRenderer(this, 18, 89);
	      body3.addBox(-3F, 30F, 2F, 6, 12, 4);
	      body3.setRotationPoint(0F, 13F, 10F);
	      body3.setTextureSize(128, 128);
	      setRotation(body3, 0F, undulationCycle[0][1], 0F);
	      body2.addChild(body3);
	      
	      fin1 = new ModelRenderer(this, 0, 38);
	      fin1.addBox(0F, 0F, 0F, 0, 6, 8);
	      fin1.setRotationPoint(0F, -1F, -4F);
	      fin1.setTextureSize(128, 128);
	      setRotation(fin1, 0F, 0F, 0F);
	      
	      fin2 = new ModelRenderer(this, 0, 80);
	      fin2.addBox(0F, 0F, 0F, 0, 6, 8);
	      fin2.setRotationPoint(0F, 0F, 14F);
	      fin2.setTextureSize(128, 128);
	      setRotation(fin2, 0F, undulationCycle[0][1], 0F);
	      fin2.addChild(body1);
	      
	      fin3 = new ModelRenderer(this, 0, 66);
	      fin3.addBox(0F, 0F, 0F, 0, 6, 8);
	      fin3.setRotationPoint(0F, 3F, 28F);
	      fin3.setTextureSize(128, 128);
	      setRotation(fin3, 0F, undulationCycle[0][1], 0F);
	      fin3.addChild(body2);
	      
	      tailFin = new ModelRenderer(this, 0, 52);
	      tailFin.addBox(0F, -2F, 0F, 0, 6, 8);
	      tailFin.setRotationPoint(0F, 9F, 48F);
	      tailFin.setTextureSize(128, 128);
	      setRotation(fin2, 0F, undulationCycle[0][1], 0F);
	      tailFin.addChild(body3);
	      
	      mouth = new ModelRenderer(this, 84, 0);
	      mouth.addBox(0F, 0F, 0F, 8, 2, 6);
	      mouth.setRotationPoint(-4F, 11F, -14F);
	      mouth.setTextureSize(128, 128);
	      setRotation(mouth, 0F, 0F, 0F);
	      
	      tooth1 = new ModelRenderer(this, 84, 8);
	      tooth1.addBox(0F, 0F, 0F, 1, 1, 1);
	      tooth1.setRotationPoint(3F, 10F, -14F);
	      tooth1.setTextureSize(128, 128);
	      setRotation(tooth1, 0F, 0F, 0F);
	      
	      tooth2 = new ModelRenderer(this, 84, 8);
	      tooth2.addBox(0F, 0F, 0F, 1, 1, 1);
	      tooth2.setRotationPoint(-4F, 10F, -14F);
	      tooth2.setTextureSize(128, 128);
	      setRotation(tooth2, 0F, 0F, 0F);

    }    

    @Override
    public void render(Entity parEntity, float parTime, float parSwingSuppress, 
          float par4, float parHeadAngleY, float parHeadAngleX, float par7)
    {
    	
        renderSerpent((EntityLavasnake) parEntity, parTime, parSwingSuppress, par4, 
              parHeadAngleY, parHeadAngleX, par7);
    }
    
    public void renderSerpent(EntityLavasnake parEntity, float parTime, float parSwingSuppress, 
          float par4, float parHeadAngleY, float parHeadAngleX, float par7)
    {
        setRotationAngles(parTime, parSwingSuppress, par4, parHeadAngleY, parHeadAngleX, 
              par7, parEntity);
        head.render(par7);
        body.render(par7);
        body1.render(par7);
        body2.render(par7);
        body3.render(par7);
        fin1.render(par7);
        fin2.render(par7);
        fin3.render(par7);
        tailFin.render(par7);
        headFin.render(par7);
        
    } 
    
    @Override
    public void setRotationAngles(float parTime, float parSwingSuppress, float par3, 
          float parHeadAngleY, float parHeadAngleX, float par6, Entity parEntity)
    {
     
        updateDistanceMovedTotal(parEntity);
        cycleIndex = (int) ((getDistanceMovedTotal(parEntity)*CYCLES_PER_BLOCK)
              %undulationCycle.length);

        System.out.println("ModelSerpent setRotationAngles(), distanceMoved ="
              +getDistanceMovedTotal(parEntity)+", cycleIndex ="+cycleIndex);
        body2.rotateAngleY = degToRad(undulationCycle[cycleIndex][0]) ;
        body3.rotateAngleY = degToRad(undulationCycle[cycleIndex][1]) ;
        fin2.rotateAngleY = degToRad(undulationCycle[cycleIndex][2]) ;
        fin3.rotateAngleY = degToRad(undulationCycle[cycleIndex][3]) ;
        tailFin.rotateAngleY = degToRad(undulationCycle[cycleIndex][4]) ;
    }
    
    protected void updateDistanceMovedTotal(Entity parEntity) 
    {
        distanceMovedTotal += parEntity.getDistance(parEntity.prevPosX, parEntity.prevPosY, 
              parEntity.prevPosZ);
    }
    
    protected double getDistanceMovedTotal(Entity parEntity) 
    {
        return (distanceMovedTotal);
    }

    protected float degToRad(float degrees)
    {
        return degrees * (float)Math.PI / 180 ;
    }
    
    protected void setRotation(ModelRenderer model, float rotX, float rotY, float rotZ)
    {
        model.rotateAngleX = degToRad(rotX);
        model.rotateAngleY = degToRad(rotY);
        model.rotateAngleZ = degToRad(rotZ);        
    }

    protected void spinX(ModelRenderer model)
    {
        model.rotateAngleX += degToRad(0.5F);
    }
    
    protected void spinY(ModelRenderer model)
    {
        model.rotateAngleY += degToRad(0.5F);
    }
    
    protected void spinZ(ModelRenderer model)
    {
        model.rotateAngleZ += degToRad(0.5F);
    }
}