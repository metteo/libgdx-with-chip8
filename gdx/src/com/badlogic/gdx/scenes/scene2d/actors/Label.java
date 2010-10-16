package com.badlogic.gdx.scenes.scene2d.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Font;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Label extends Actor 
{
	public Font font;
	public String text;
	public final Color color = new Color( 1, 1, 1, 1 );
	
	public Label( String name, Font font, String text )
	{
		super(name);
		this.font = font;
		this.text = text;
	}
	
	@Override
	protected void render(SpriteBatch batch) 
	{
		batch.drawText( font, text, x, y, color );
	}

	@Override
	protected boolean touchDown(float x, float y, int pointer) 
	{
		return x > 0 && y > 0 && x < font.getStringWidth( text ) && x < font.getLineHeight() ;
	}

	@Override
	protected boolean touchUp(float x, float y, int pointer) 
	{
		return x > 0 && y > 0 && x < font.getStringWidth( text ) && x < font.getLineHeight() ;
	}

	@Override
	protected boolean touchDragged(float x, float y, int pointer) 
	{
		return x > 0 && y > 0 && x < font.getStringWidth( text ) && x < font.getLineHeight() ;
	}

	@Override
	public Actor hit(float x, float y) 
	{
		return  x > 0 && y > 0 && x < font.getStringWidth( text ) && x < font.getLineHeight()?this:null ;
	}

}