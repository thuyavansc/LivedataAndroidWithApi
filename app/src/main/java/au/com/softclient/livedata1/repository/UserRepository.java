package au.com.softclient.livedata1.repository;

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
