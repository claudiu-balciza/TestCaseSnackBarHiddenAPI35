package TestCaseSnackBarHiddenAPI35;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

public class MyFragment extends DialogFragment {
  private Context context;
  private Boolean layoutRecentlyInflated = true;
  Button button3;
  Button button4;
  EditText editText2;
  ConstraintLayout frame1;
  ScrollView scrollView;

  static MyFragment newInstance() {

    return new MyFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    int style, theme;
    style = DialogFragment.STYLE_NORMAL;
    theme = android.R.style.Theme_DeviceDefault;
    setStyle(style, theme);
  }

  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {

    context = requireActivity().getApplicationContext();
    layoutRecentlyInflated = true;

    View rootView = inflater.inflate(R.layout.my_fragment, container, false);

    button3 = rootView.findViewById(R.id.button3);
    button4 = rootView.findViewById(R.id.button4);
    editText2 = rootView.findViewById(R.id.editText2);
    frame1 = rootView.findViewById(R.id.frame1);
    scrollView = rootView.findViewById(R.id.scrollView);

    button3.setOnClickListener(v -> {
        frame1.post(() -> {
          frame1.scrollTo(0, 0);
          editText2.requestFocus();
        });

        Snackbar.make(frame1,
                "this snackbar shows ok in API34",
                Snackbar.LENGTH_INDEFINITE)
            .show();

    });

    button4.setOnClickListener(v -> dismiss());

    ViewCompat.setOnApplyWindowInsetsListener(scrollView, (v, windowInsets) -> {
      if (layoutRecentlyInflated) {
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        mlp.topMargin = insets.top;
        mlp.bottomMargin = insets.bottom;
        mlp.leftMargin = insets.left;
        mlp.rightMargin = insets.right;
        v.setLayoutParams(mlp);
        layoutRecentlyInflated = false;
      }

      return WindowInsetsCompat.CONSUMED;
    });

    return rootView;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    editText2.requestFocus();
    getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
  }


}
