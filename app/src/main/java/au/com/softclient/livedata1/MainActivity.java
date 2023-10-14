package au.com.softclient.livedata1;
//import au.com.softclient.livedata1.databinding.ActivityMainBinding;
//import android.viewbinding.ViewBinding;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import au.com.softclient.livedata1.databinding.ActivityMainBinding;
import au.com.softclient.livedata1.models.User;
import au.com.softclient.livedata1.viewmodels.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;
    private ActivityMainBinding binding; // Declare the binding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Initialize the binding
        setContentView(binding.getRoot()); // Use the binding's root view

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUserData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                // Update the UI with the user data using the binding
                binding.userNameTextView.setText("User Name: " + user.getName());
                binding.userEmailTextView.setText("User Email: " + user.getEmail());
            }
        });

        userViewModel.fetchUser(); // Fetch user data
    }
}