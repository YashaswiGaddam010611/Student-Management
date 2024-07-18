package com.yashaswi.lc.propertyEditors;

import java.beans.PropertyEditorSupport;

public class CustomNameEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String editedText = text.toUpperCase();
		setValue(editedText);
	}
}
