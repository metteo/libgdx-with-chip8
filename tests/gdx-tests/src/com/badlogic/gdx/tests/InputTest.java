/*******************************************************************************
 * Copyright 2010 Mario Zechner (contact@badlogicgames.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.badlogic.gdx.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputListener;
import com.badlogic.gdx.RenderListener;

public class InputTest implements RenderListener, InputListener
{	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceChanged(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated() {
		Gdx.input.addInputListener( this );
	}

	@Override
	public boolean keyDown(int keycode) 
	{
		Gdx.app.log( "Input Test", "key down: " + keycode );
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		Gdx.app.log( "Input Test", "key typed: '" + character + "'" );
		return false;
	}

	@Override
	public boolean keyUp(int keycode) 
	{
		Gdx.app.log( "Input Test", "key up: " + keycode );
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer) 
	{
		Gdx.app.log( "Input Test", "touch down: " + x + ", " + y );
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		Gdx.app.log( "Input Test", "touch dragged: " + x + ", " + y );
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer) {
		Gdx.app.log( "Input Test", "touch up: " + x + ", " + y );
		return false;
	}


}