package com.pfariasmunoz.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    // Call onSendMessage() when the button is clicked
    public void onSendMessage(View view) {
        // get the EditText view of the layout with the id: message
        EditText messageView = (EditText) findViewById(R.id.message);
        // get the text added by the user in the EditText
        String messageText = messageView.getText().toString();
        // Create a new Intent with an action of SEND
        Intent intent = new Intent(Intent.ACTION_SEND);
        // set the MIME type for the Intent
        intent.setType("text/plain");
        // Add to the Intent the text from the EditText view
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        // get the text form a string resource
        String chooserTitle = getString(R.string.chooser);
        // wrap the Intent in a chooser so Android always ask for with app to choose
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        // Start the activity of whatever app is available
        startActivity(chosenIntent);
    }
}
