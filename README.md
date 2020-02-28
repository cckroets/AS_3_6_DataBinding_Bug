# AS_3_6_DataBinding_Bug

Demos wrong package name for databinding class in Android Studio 3.6

Define two nested layouts in two separate modules:

`hello_world_1.xml` in `mylibrary`
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <include
            android:id="@+id/hello2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            layout="@layout/hello_world_2"/>

    </FrameLayout>
</layout>
```
and `hellow_world_2.xml` in `mylibrary2`. (`mylibrary` depends on `mylibrary2`)
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:minHeight="?android:attr/actionBarSize"/>
</layout>
```

Then try to use the nested binding in Java source code living in `mylibrary`

```java
import com.github.cckroets.mylibrary.databinding.HelloWorld1Binding;
import com.github.cckroets.mylibrary2.databinding.HelloWorld2Binding;

public class HelloWorldData1 {

    public static void hello(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup container) {
        HelloWorld1Binding binding = HelloWorld1Binding.inflate(layoutInflater, container, false);

        // AS 3.6 gives: 'Incompatible types.'
        // Required: com.github.cckroets.mylibrary2.databinding.HelloWorld2Binding
        // Found:    com.github.cckroets.mylibrary.databinding.HelloWorld2Binding
        HelloWorld2Binding nestedBinding = binding.hello2;
    }
}
```
Android Studio 3.6 for thinks the nested binding classes are under the root binding's package name.

