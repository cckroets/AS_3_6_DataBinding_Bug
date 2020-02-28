# AS_3_6_DataBinding_Bug
Demos a bug in resolving Binding files in AS 3.6 with custom resource dirs

Issue tracked here:
https://issuetracker.google.com/issues/149630915

Defining custom resource directories like so:
```gradle
    defaultConfig {
        sourceSets {
            main.res.srcDirs = [
                    'src/main/res/one',
                    'src/main/res/two'
            ]
        }
    }
```
Will make AS 3.6 not resolve DataBinding classes

```java
package com.github.cckroets.mylibrary;

// AS 3.6 gives: 'Cannot resolve symbol'
import com.github.cckroets.mylibrary.databinding.HelloWorld1Binding;

public class HelloWorldData1 {

    private HelloWorld1Binding binding;
}
```
