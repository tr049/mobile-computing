package pk.edu.pucit.mc.sqldemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_student);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_student, menu);
		return true;
	}

	public void onClick(View v){
		SQLiteDatabase db = new MySQLiteOpenHelper(this).getWritableDatabase();
		String rollNumber = ((EditText)findViewById(R.id.student_rollnumber)).getText().toString();
		String name = ((EditText)findViewById(R.id.student_name)).getText().toString();
		float cgpa = Float.parseFloat(((EditText)findViewById(R.id.student_cgpa)).getText().toString());
		ContentValues values = new ContentValues();
		values.put(SQLDemoContract.tables.StudentEntry._ID, rollNumber);
		values.put(SQLDemoContract.tables.StudentEntry.COLUMN_NAME_ROLL_NUMBER, rollNumber);
		values.put(SQLDemoContract.tables.StudentEntry.COLUMN_NAME_NAME, name);
		values.put(SQLDemoContract.tables.StudentEntry.COLUMN_NAME_CGPA, cgpa);
		db.insert(SQLDemoContract.tables.StudentEntry.TABLE_NAME, null, values);
		Toast.makeText(this, "Data inserted", Toast.LENGTH_LONG).show();
	}
	
}
