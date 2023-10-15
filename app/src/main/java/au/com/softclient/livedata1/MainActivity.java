package au.com.softclient.livedata1;
//import au.com.softclient.livedata1.databinding.ActivityMainBinding;
//import android.viewbinding.ViewBinding;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import au.com.softclient.livedata1.databinding.ActivityMainBinding;
import au.com.softclient.livedata1.models.User;
import au.com.softclient.livedata1.repository.UserRepository;
import au.com.softclient.livedata1.viewmodels.UserViewModel;

//package au.com.softclient.livedata1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import au.com.softclient.livedata1.databinding.ActivityMainBinding;
import au.com.softclient.livedata1.models.User;
import au.com.softclient.livedata1.viewmodels.UserViewModel;


//package au.com.softclient.livedata1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import au.com.softclient.livedata1.databinding.ActivityMainBinding;
import au.com.softclient.livedata1.models.User;
import au.com.softclient.livedata1.viewmodels.UserViewModel;



// MainActivity.java
//package com.yourpackage;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;
import android.os.Handler;
import android.os.Looper;

//import com.yourpackage.models.User;
//import com.yourpackage.viewmodels.UserViewModel;


// MainActivity.java


public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.userNameTextView);
        emailTextView = findViewById(R.id.userEmailTextView);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // Create a handler for the main thread
        final Handler mainHandler = new Handler(Looper.getMainLooper());

        // Pass the handler to the repository
        UserRepository userRepository = new UserRepository(mainHandler);

        userViewModel.getUserData(1, userRepository).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    nameTextView.setText(user.getName());
                    emailTextView.setText(user.getEmail());
                    Log.d("EA1", user.getName() + " Activity error " + user.getEmail());
                }
            }
        });
    }
}


/*
public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.userNameTextView);
        emailTextView = findViewById(R.id.userEmailTextView);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUserData(1).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    nameTextView.setText(user.getName());
                    emailTextView.setText(user.getEmail());
                    Log.d("EA1", user.getName() + " Activity error " + user.getEmail());
                }
            }
        });
    }
}

*/

/*
public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.userNameTextView);
        emailTextView = findViewById(R.id.userEmailTextView);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUserData(1).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            nameTextView.setText(user.getName());
                            emailTextView.setText(user.getEmail());
                            Log.d("EA1", user.getName() + "Activity error" + user.getEmail());
                        }
                    });
                }
            }
        });
    }
}
*/

/*
public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.userNameTextView);
        emailTextView = findViewById(R.id.userEmailTextView);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUserData(1).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            nameTextView.setText(user.getName());
                            emailTextView.setText(user.getEmail());
                            Log.d("EA1",user.getName()+"Activity error"+user.getEmail());
                        }
                    });
                }
            }
        });
    }
}

*/

/*
public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.userNameTextView);
        emailTextView = findViewById(R.id.userEmailTextView);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // Observe LiveData for user data changes
        userViewModel.getUserData(1).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            nameTextView.setText(user.getName());
                            emailTextView.setText(user.getEmail());
                            Log.d("EA1",user.getName()+"Activity error"+user.getEmail());
                        }
                    });
                }
            }
        });
*/
        /*
        userViewModel.getUserData(1).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    nameTextView.setText(user.getName());
                    emailTextView.setText(user.getEmail());
                }
            }
        });
    }
}
*/

/*
public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;
    private ActivityMainBinding binding; // Declare the binding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        userViewModel.fetchUser(); // Fetch user data for ID 1
    }
}

*/

/*I
public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUserData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.userNameTextView.setText("User Name: " + user.getName());
                binding.userEmailTextView.setText("User Email: " + user.getEmail());
            }
        });

        userViewModel.fetchUser(); // Fetch user data for ID 1
    }
}

*/
/*
public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUserData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.userNameTextView.setText("User Name: " + user.getName());
                binding.userEmailTextView.setText("User Email: " + user.getEmail());
            }
        });

        userViewModel.fetchUser(); // Fetch user data
    }
}
*/

/*
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
*/