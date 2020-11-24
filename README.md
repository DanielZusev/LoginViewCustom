[![](https://jitpack.io/v/DanielZusev/LoginCustomView.svg)](https://jitpack.io/#DanielZusev/LoginCustomView)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# CustomLoginView
An Android library that implements a simple custom login view

## Setup
#### Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
#### Add the dependency
```
dependencies {
	        implementation 'com.github.DanielZusev:LoginViewCustom:1.00.01'
	}
```
## Usage
![](LoginCustomViewGif.gif)

## Xml
```
<com.daniel.logincustomview.LoginView
	app:inputTextHint="@string/user_name"
	app:passTextHint="@string/Password"
	app:buttonText="@string/click"
	app:headerText="@string/login"
	app:buttonTextColor="@color/black">	
```

## Java

#### Set Header Text
```
loginView.setHeaderText("Login");
```
#### Set Input Text
```
loginView.setInputTextHint("User");
```
#### Set Password Text
```
 loginView.setPassTextHint("Password");
```
#### Set Button Text
```
loginView.setButtonText("Click Me");
```
#### Get Input Text
```
String inputValue = loginView.getInputTextValue();
```
#### Get Password Text
```
 String passValue = loginView.getPassTextValue();
```
#### Set Button Listener
```
loginView.setButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loginView.setButtonText("Clicked !");
            }
        });
```
## License

    Copyright 2020 Daniel Zusev

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


