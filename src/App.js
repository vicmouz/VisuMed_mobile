import React, { useEffect } from 'react';
import { useSelector } from 'react-redux';
import SplashScreen from 'react-native-splash-screen';
import NavigationService from './routes/navigation.service';

import createRoutes from './routes';

const App = () => {
  useEffect(() => {
    setTimeout(() => {
      SplashScreen.hide();
    }, 200);
  }, []);

  const signed = useSelector(state => state.auth.signed);

  const Routes = createRoutes(signed);

  return (
    <Routes
      ref={navigatorRef => {
        NavigationService.setTopLevelNavigator(navigatorRef);
      }}
    />
  );
};

const OverlayApp = __DEV__ ? console.tron.overlay(App) : App;

export default OverlayApp;
