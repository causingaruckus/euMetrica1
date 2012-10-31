package com.example.project1;

public class ListItemObject {
	public String text;
	public String leftImage;
	public String rightImage;

	public ListItemObject(String text, String leftImage, String rightImage) {
		this.text = text;
		this.leftImage = leftImage;
		this.rightImage = rightImage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLeftImage() {
		return leftImage;
	}

	public void setLeftImage(String leftImage) {
		this.leftImage = leftImage;
	}

	public String getRightImage() {
		return rightImage;
	}

	public void setRightImage(String rightImage) {
		this.rightImage = rightImage;
	}

}
