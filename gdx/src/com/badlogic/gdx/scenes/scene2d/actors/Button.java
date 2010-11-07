
package com.badlogic.gdx.scenes.scene2d.actors;

import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * A simple Button {@link Actor}, useful for simple UIs
 * 
 * @author mzechner
 *
 */
public class Button extends Actor {
	public interface ClickListener {
		public void clicked (Button button);
	}

	public final TextureRegion pressedRegion;
	public final TextureRegion unpressedRegion;
	public ClickListener clickListener;
	private boolean pressed = false;

	/**
	 * Creates a new Button instance with the given name.
	 * @param name the name 
	 */
	public Button (String name) {
		super(name);
		this.pressedRegion = new TextureRegion(null, 0, 0, 0, 0);
		this.unpressedRegion = new TextureRegion(null, 0, 0, 0, 0);
	}

	/**
	 * Creates a new Button instance with the given name, using
	 * the complete supplied texture for displaying the pressed
	 * and unpressed state of the button.
	 * @param name the name
	 * @param texture the {@link Texture}
	 */
	public Button (String name, Texture texture) {
		super(name);
		this.originX = texture.getWidth() / 2.0f;
		this.originY = texture.getHeight() / 2.0f;
		this.width = texture.getWidth();
		this.height = texture.getHeight();
		this.pressedRegion = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
		this.unpressedRegion = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
	}

	public Button (String name, TextureRegion region) {
		this(name, region, region);
	}

	public Button (String name, TextureRegion unpressedRegion, TextureRegion pressedRegion) {
		super(name);
		this.originX = unpressedRegion.width / 2.0f;
		this.originY = unpressedRegion.height / 2.0f;
		this.width = unpressedRegion.width;
		this.height = unpressedRegion.height;
		this.unpressedRegion = new TextureRegion(unpressedRegion.texture, unpressedRegion.x, unpressedRegion.y,
			unpressedRegion.width, unpressedRegion.height);
		this.pressedRegion = new TextureRegion(pressedRegion.texture, pressedRegion.x, pressedRegion.y, pressedRegion.width,
			pressedRegion.height);

	}

	@Override protected void render (SpriteBatch batch) {
		TextureRegion region = pressed ? pressedRegion : unpressedRegion;

		if (region.texture != null) {
			if (scaleX == 0 && scaleY == 0 && rotation == 0)
				batch.draw(region.texture, x, y, width, height, region.x, region.y, region.width, region.height, color, false, false);
			else
				batch.draw(region.texture, x, y, originX, originY, width, height, scaleX, scaleY, rotation, region.x, region.y,
					region.width, region.height, color, false, false);
		}
	}

	@Override protected boolean touchDown (float x, float y, int pointer) {
		boolean result = x > 0 && y > 0 && x < width && y < height;
		pressed = result;
		if (pressed) parent.focus(this);
		return result;
	}

	@Override protected boolean touchUp (float x, float y, int pointer) {
		if (!pressed) return false;

		parent.focus(null);
		pressed = false;
		if (clickListener != null) clickListener.clicked(this);
		return true;
	}

	@Override protected boolean touchDragged (float x, float y, int pointer) {
		return true;
	}

	public Actor hit (float x, float y) {
		return x > 0 && y > 0 && x < width && y < height ? this : null;
	}

}
