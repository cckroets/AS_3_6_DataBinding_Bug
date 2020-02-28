# AS_3_6_DataBinding_Bug

Demos a bug in resolving nested bindings in AS/AGP 3.6.

`mylibrary` defines a layout:

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
That layout includes a layout `@layout/hello_world_2` from another library module:
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
which has a View with an ID toolbar.

We should be able to reference this toolbar in Java, like so:
```java
public class HelloWorldData1 {

    public static void hello(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup container) {
        HelloWorld1Binding binding = HelloWorld1Binding.inflate(layoutInflater, container, false);

        // AS 3.6 gives: 'Cannot resolve symbol: toolbar'
        System.out.println(binding.hello2.toolbar);
    }
}

```
This compiles and builds correctly, but AS 3.6 will not resolve `toolbar` in the IDE.

 

