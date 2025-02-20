package TestCaseSnackBarHiddenAPI35;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "TestCaseSnackBarHiddenAPI35:activityMain:";
  Context myContext;
  private Boolean layoutRecentlyInflated = true;
  private ConstraintLayout mainLayout;
  private Button button1;
  private Button button2;
  private EditText editText1;


    @Override
  protected void onCreate(Bundle savedInstanceState) {
    EdgeToEdge.enable(this);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myContext = getApplicationContext();

    mainLayout = findViewById(R.id.mainLayout);
    button1 = findViewById(R.id.button1);
    button2 = findViewById(R.id.button2);
    editText1 = findViewById(R.id.editText1);

    ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, windowInsets) -> {
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

    button1.setOnClickListener(v -> {

      editText1.requestFocus();
      this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

      Snackbar.make(mainLayout,
          "snackbar moves around on repeated invocation",
          Snackbar.LENGTH_INDEFINITE).show();

    });

    button2.setOnClickListener(v -> {
      MyFragment frag = MyFragment.newInstance();
      frag.show(getSupportFragmentManager(), "my_fragment");
    });

  }

}