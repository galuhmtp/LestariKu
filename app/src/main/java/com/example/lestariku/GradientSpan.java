package com.example.lestariku;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

public class GradientSpan extends CharacterStyle implements UpdateAppearance {
    private final int startColor;
    private final int endColor;

    public GradientSpan(int startColor, int endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        Rect bounds = new Rect();
        tp.getTextBounds("Bumi Lestari", 0, "Bumi Lestari".length(), bounds);

        Shader shader = new LinearGradient(
                0, 0, bounds.width(), 0,
                startColor, endColor,
                Shader.TileMode.CLAMP
        );
        tp.setShader(shader);
    }
}
