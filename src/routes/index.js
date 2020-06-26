import { createAppContainer, createSwitchNavigator } from 'react-navigation';
import { createBottomTabNavigator } from 'react-navigation-tabs';
import { createStackNavigator } from 'react-navigation-stack';

import createObjectNavOptionTabDefault from './createObjectNavOptionTabDefault';

import Login from '~/pages/Login';
import Home from '~/pages/Home';

import { colors } from '~/styles/themes';

export default (isSigned = false) =>
  createAppContainer(
    createSwitchNavigator(
      {
        Sign: createSwitchNavigator({
          Login,
        }),
        App: createBottomTabNavigator(
          {
            Inicio: createStackNavigator(
              {
                Home,
              },
              createObjectNavOptionTabDefault({
                tabBarLabel: 'Início',
                icon: 'home',
              })
            ),
          },
          {
            tabBarOptions: {
              keyboardHidesTabBar: false,
              activeTintColor: colors.secondary,
              inactiveTintColor: colors.primary,
              style: {
                backgroundColor: colors.light,
                height: 58,
                borderTopRightRadius: 4,
                borderTopLeftRadius: 4,
              },
              labelStyle: {
                fontSize: 10,
                letterSpacing: -0.36,
                marginBottom: 4,
              },
            },
          }
        ),
      },
      {
        initialRouteName: isSigned ? 'App' : 'Sign',
      }
    )
  );
