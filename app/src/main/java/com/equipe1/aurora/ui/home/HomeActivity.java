package com.equipe1.aurora.ui.home;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.equipe1.aurora.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        // 1. Localiza o FragmentContainerView do XML
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_graph);

        if (navHostFragment != null) {
            // 2. Obtém o NavController (gerenciador de rotas)
            NavController navController = navHostFragment.getNavController();
            BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

            // 3. Conecta automaticamente os cliques do menu com a troca dos fragmentos
            NavigationUI.setupWithNavController(bottomNav, navController);
        }
    }
}