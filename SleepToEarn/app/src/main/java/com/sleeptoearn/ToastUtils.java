package com.sleeptoearn;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.sleeptoearn.R;

public class ToastUtils {
    ///Method to show a customToast in an activity
    public static void CustomToast(Context _context, String _message, int _textSize, int _bgColor, int _radius, int _gravity) {
    LayoutInflater inflater = LayoutInflater.from(_context);
    View _view = inflater.inflate(R.layout.custom_toast_layout, null);
    TextView _textView = _view.findViewById(R.id.custom_toast_text);
    _textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, _textSize);
    _textView.setText(_message);

    GradientDrawable _gradientDrawable = new GradientDrawable();
    _gradientDrawable.setColor(_bgColor);
    _gradientDrawable.setCornerRadius(_radius);
    _view.setBackground(_gradientDrawable);

    Toast _toast = new Toast(_context);
    _toast.setDuration(Toast.LENGTH_SHORT);

    switch (_gravity) {
        case 1:
            _toast.setGravity(Gravity.TOP, 0, 150);
            break;
        case 2:
            _toast.setGravity(Gravity.CENTER, 0, 0);
            break;
        case 3:
            _toast.setGravity(Gravity.BOTTOM, 0, 150);
            break;
    }

    _toast.setView(_view);
    _toast.show();
}

    
}
