import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;


@SuppressLint("NewApi")
public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTests( ) {
		super(IntentReaderActivity.class);
	}
	
	public void testSendText(){
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		//intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("In", text, activity.getText());

		
	}
	public void testDoubleSendText(){
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("In", text + text , activity.getText());

		
	}
	
	public void testReverseSendText(){
		Intent intent = new Intent();
		String text = "";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		
		assertEquals("In", "", activity.getText());
	}
	
	
	
	public void testDisplayText(){
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		//intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		assertEquals("Display text", text, textView.getText().toString());
	}
	
	public void testViewDisplayText(){
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		//intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		View view = activity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(view, textView);
	}
	
	
	
}
