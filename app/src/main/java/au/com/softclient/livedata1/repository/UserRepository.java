package au.com.softclient.livedata1.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import au.com.softclient.livedata1.models.User;
import au.com.softclient.livedata1.services.UserService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//package au.com.softclient.livedata1.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import au.com.softclient.livedata1.models.User;
import au.com.softclient.livedata1.services.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


// UserRepository.java
//package com.yourpackage.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import android.os.Handler;
import android.os.Looper;

//import com.yourpackage.models.User;

// UserRepository.java

public class UserRepository {

    private UserService userService;
    private final Handler mainHandler;

    public UserRepository(Handler mainHandler) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.168:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
        this.mainHandler = mainHandler;
    }

    public LiveData<User> getUserData(int userId) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();

        userService.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                userLiveData.setValue(user);
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLiveData.postValue(new User(1, "Fail", "fail@gmail.com"));
                    }
                });
                Log.d("E2", "API call Failed - onFailure");
            }
        });

        return userLiveData;
    }
}


/*
public class UserRepository {

    private UserService userService;
    private Handler mainHandler;

    public UserRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.168:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public LiveData<User> getUserData(int userId) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();

        userService.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                userLiveData.setValue(user);
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLiveData.postValue(new User(1, "Fail", "fail@gmail.com"));
                    }
                });
                Log.d("E2", "API call Failed - onFailure");
            }
        });

        return userLiveData;
    }
}

*/
/*
public class UserRepository {

    private Context context;
    private UserService userService;

    public UserRepository(Context context) {
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.168:3000") // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
    }

    public LiveData<User> getUserData(int userId) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();

        userService.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                userLiveData.setValue(user);
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                userLiveData.postValue(new User(1, "Fail", "fail@gmail.com"));
                Log.d("E2", "API call Failed - onFailure");
            }
        });

        return userLiveData;
    }
}
*/

/*
public class UserRepository {

    private UserService userService;

    public UserRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.168:3000") // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
        Log.d("E4", "4");
    }

    public LiveData<User> getUserData(int userId) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();

        userService.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        Log.d("E1", "ID: " + user.getId());
                        Log.d("E1", "Name: " + user.getName());
                        Log.d("E1", "Email: " + user.getEmail());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                userLiveData.setValue(user);
                            }
                        });
                    }

                    String requestUrl = call.request().url().toString();
                    Log.d("API_Url->", "API URL: " + requestUrl);
                    Log.d("API_Response", "Response: " + response.toString());
                    Log.d("E1","This means API call is Successful");
                } else {
                    Log.d("E0","API call failed");
                }
            }


            /*
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body(); // Access the user object directly
                    if (user != null) {
                        Log.d("E1", "ID: " + user.getId());
                        Log.d("E1", "Name: " + user.getName());
                        Log.d("E1", "Email: " + user.getEmail());
                        userLiveData.setValue(user);
                    }

                    String requestUrl = call.request().url().toString();
                    Log.d("API_Url->", "API URL: " + requestUrl);
                    Log.d("API_Response", "Response: " + response.toString());
                    Log.d("E1", "This means the API call is Successful");
                } else {
                    Log.d("E0", "API call failed");
                }
            }



            @Override
            public void onFailure(Call<User> call, Throwable t) {
                userLiveData.postValue(new User(1, "Fail", "fail@gmail.com"));
                Log.d("E2", "API call Failed - onFailure");
            }
        });

        return userLiveData;
    }

}
*/
/*
public class UserRepository {

    private UserService userService;

    public UserRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.168:3000") // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
        Log.d("E4","4");
    }

    public LiveData<User> getUserData(int userId) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();

        userService.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        // Log the values from the User object
                        Log.d("E1", "ID: " + user.getId());
                        Log.d("E1", "Name: " + user.getName());
                        Log.d("E1", "Email: " + user.getEmail());

                        // Set the value in the LiveData
                        userLiveData.setValue(user);
                    }

                    // Get the request URL from the original request
                    String requestUrl = call.request().url().toString();
                    Log.d("API_Url->", "API URL: " + requestUrl);
                    Log.d("API_Response", "Response: " + response.toString());
                    Log.d("E1","This means Api call is Successful");
                } else {
                    Log.d("E0","Api call failed");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle failure
                userLiveData.postValue(new User(1, "Fail", "fail@gmail.com"));
                Log.d("E2","Api call Failed - onfailure");
            }
        });

        return userLiveData;
    }
*/
    /*
    public LiveData<User> getUserData(int userId) {
        MutableLiveData<User> userLiveData = new MutableLiveData<>();

        userService.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                    //userLiveData.setValue(response.body());
                    User user = response.body();
                    if (user != null) {
                        // Log the values from the User object
                        Log.d("E1", "ID: " + user.getId());
                        Log.d("E1", "Name: " + user.getName());
                        Log.d("E1", "Email: " + user.getEmail());

                        // Set the value in the LiveData
                        userLiveData.setValue(user);

                    // Get the request URL from the original request
                    String requestUrl = call.request().url().toString();
                    Log.d("API_Url->", "API URL: " + requestUrl);
                    Log.d("API_Response", "Response: " + response.toString());
                    Log.d("E1","This means Api call is Successful");
                }}
                else {
                    Log.d("E0","Api call failed");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle failure
                userLiveData.postValue(new User(1, "Fail", "fail@gmail.com"));
                Log.d("E2","Api call Failed - onfailure");
            }
        });
        Log.d("E3","3");
        return userLiveData;

    }


}
*/
/*
public class UserRepository {

    private MutableLiveData<User> userLiveData;

    public LiveData<User> getUserData(int userId) {
        // Simulate an API call to fetch user data
        if (userLiveData == null) {
            userLiveData = new MutableLiveData<>();
            // Replace this with your actual API call
            // For example, you can use Retrofit or any other networking library
            User user = new User(1, "John Doe", "johndoe@example.com");
            userLiveData.setValue(user);
        }
        return userLiveData;
    }
}

*/
/*
public class UserRepository {

    private MutableLiveData<User> userData = new MutableLiveData<>();
    private UserService userService;

    public UserRepository() {
        // Create a Retrofit instance with the base URL for user ID 1.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.168:3000/api/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
    }

    public LiveData<User> getUserData() {
        return userData;
    }

    public void fetchUser() {
        //User user = // Fetch user data.
        User user =new User(1,"2John Doe ", "2johndoe@example.com");
        // Make the API call to fetch user data for ID 1.
        /*
        Call<User> call = userService.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        userData.postValue(user); // Update the LiveData with the new user data.
                    } else {
                        // Handle the case where the API returned data that doesn't match the expected structure.
                        // You can set a default "fail" user here or handle it in another way.
                        userData.postValue(new User(1, "Fail", "fail@gmail.com"));
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle API call failure here
                // Set a default "fail" user in case of failure.
                userData.postValue(new User(1, "Fail", "fail@gmail.com"));
            }
        });

    }
}

 */


/*
public class UserRepository {
    private MutableLiveData<User> userData = new MutableLiveData<>();
    private UserService userService;

    public UserRepository() {
        // Create a Retrofit instance with your base URL and add the UserService.
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("http://localhost:3000/api/")
                //.baseUrl("http://192.168.56.1:3000/api/")
                .baseUrl("http://192.168.8.168:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
    }

    public LiveData<User> getUserData() {
        return userData;
    }

    public void fetchUser() {
        // Simulate fetching data for ID 1 from the API
        // In a real app, you would use Retrofit to make the API call.
        // For this example, we're just simulating data.

        // Simulate API call
        Call<User> call = userService.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null && user.getId() == 1) {
                        userData.postValue(user); // Update the LiveData with the new data for ID 1.
                    } else {
                        // Handle the case where the API returned data for a different user.
                        // You can set a default "fail" user here.
                        userData.postValue(new User(0,"Fail", "fail@gmail.com"));
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle API call failure here
                // Set a default "fail" user in case of failure.
                userData.postValue(new User(0,"Fail", "fail@gmail.com"));
            }
        });
    }
}
*/

/*
public class UserRepository {
    private MutableLiveData<User> userData = new MutableLiveData<>();
    private UserService userService;

    public UserRepository(UserService userService) {
        this.userService = userService;
    }

    public LiveData<User> getUserData() {
        return userData;
    }

    public void fetchUser() {
        // In a real app, fetch user data from a database, API, or other source.
        //User user = // Fetch user data.
        //User user =new User("John Doe ", "johndoe@example.com");
        //userData.postValue(user); // Update the LiveData with the new data.

        // Simulate fetching data from the API
        // In a real app, you would use Retrofit to make the API call.
        // For this example, we're just simulating data.

        // Create a Retrofit instance with your base URL and add the UserService.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://your.api.url/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);

        // Make the API call
        Call<User> call = userService.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    userData.postValue(user); // Update the LiveData with the new data.
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle API call failure here
            }
        });

    }
}
*/
