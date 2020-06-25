import React from 'react';
import { Icon } from 'native-base';

export default function({ tabBarLabel, icon, typeIcon, tabBarVisible }) {
  return {
    headerMode: 'none',
    navigationOptions: {
      tabBarVisible,
      keyboardHidesTabBar: false,
      tabBarLabel: tabBarLabel || 'Tab Name',
      tabBarIcon: ({ tintColor }) => (
        <Icon
          name={icon}
          type={typeIcon}
          size={20}
          style={{ color: tintColor, marginTop: 9 }}
        />
      ),
    },
  };
}

// android:windowSoftInputMode="stateAlwaysHidden|adjustPan|adjustResize"
