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

