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
package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.backends.android.AndroidInput.Event;
import com.badlogic.gdx.backends.android.AndroidInput.EventType;

import android.view.MotionEvent;

/**
 * Single touch handler for devices running <= 1.6
 * 
 * @author badlogicgames@gmail.com
 *
 */
public class AndroidSingleTouchHandler implements AndroidTouchHandler
{
	public void onTouch( MotionEvent event, AndroidInput input )
	{
		int x = (int)event.getX();
		int y = (int)event.getY();
		input.touchX[0] = x;
		input.touchY[0] = y;
		if( event.getAction() == MotionEvent.ACTION_DOWN )
		{
			postTouchEvent(input, EventType.MouseDown, x, y, 0 );
			input.touched[0] = true;
		}
		
		if( event.getAction() == MotionEvent.ACTION_MOVE )
		{
			postTouchEvent(input, EventType.MouseDragged, x, y, 0 );
			input.touched[0] = true;			
		}
		if( event.getAction() == MotionEvent.ACTION_UP )
		{			
			postTouchEvent(input, EventType.MouseUp, x, y, 0 );
			input.touched[0] = false;			
		}
		
		if( event.getAction() == MotionEvent.ACTION_CANCEL )
		{				
			postTouchEvent(input, EventType.MouseUp, x, y, 0 );
			input.touched[0] = false;			
		}
	}
	
	private void postTouchEvent( AndroidInput input, EventType type, int x, int y, int pointer )
	{
		synchronized( input.eventQueue )
		{
			Event ev = input.freeEvents.get(input.freeEventIndex++);
			ev.set( type, x, y, pointer, 0, '\0' );
			input.eventQueue.add( ev );
		}		
	}
}