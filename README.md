
Enables Swing support
---------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/swing](http://artifacts.griffon-framework.org/plugin/swing)


Enables the usage of Swing based components in Views.

Usage
-----
This plugin enables the usage of the following nodes inside a View.

### Swing Nodes

All nodes from [SwingBuilder][1]. All nodes follow a naming convention that
makes it easy to determine the type of object the create. Take for example
*JButton*. Remove the first character from the name (J) then uncapitalize the
next one. You end up with *button*. That's the name of the node you must use if
what you want is to create an instance of a *JButton*. Apply the same rule for
every Swing class that begins with a capital J. For all other classes you only
need to uncapitalize the first character, for example *GridLayout* becomes
*gridLayout*.

### Groovy Nodes

The following nodes are provided by [SwingBuilder][1] too, however they have no
direct relationship with a particular Swing/AWT class.

 * widget
 * container
 * bean
 * noparent
 * application

### Property Editors

This plugin contributes the following property editors

| *Type*                       | *Format*                                            |
| ---------------------------- | --------------------------------------------------- |
| java.awt.Color               | #RGB ; #RGBA ; #RRGGBB; #RRGGBBAA ; Color constant  |
| java.awt.Dimension           | width, height                                       |
| java.awt.Font                | family-style-size                                   |
| java.awt.GradientPaint       | x1, y1, #RGB, x2, y2, #RGB, CYCLIC                  |
| java.awt.Image               | path/to/image_file                                  |
| java.awt.Insets              | top, left, bottom, right                            |
| java.awt.LinearGradientPaint | xy, y1, x2, x2, [0.0, 1.0], [#RGB, #RGB], REPEAT    |
| java.awt.Point               | x, y                                                |
| java.awt.Polygon             | x1, y1, x2, y2, ..., xn, yn                         |
| java.awt.RadialGradientPaint | xy, y1, r, fx, fy, [0.0, 1.0], [#RGB, #RGB], REPEAT |
| java.awt.Rectangle           | x, y, width, height                                 |
| java.awt.geom.Point2D        | x, y                                                |
| java.awt.geom.Rectangle2D    | x, y , width, height                                |
| javax.swing.Icon             | path/to/image_file                                  |

Notes:

 * CYCLIC may be `true` or `false`.
 * REPEAT must be one of `MultipleGradientPaint.CycleMethod`.
 * GradientPaint supports another format: x1, y1 | x2, y2, | #RGB, #RGB | CYCLIC
 * Color supports all color constants defined by `griffon.swing.Colors`.
 * All color formats are supported by gradient editors.

The following styles are supported by `FontPropertyEditor`

 * BOLD
 * ITALIC
 * BOLDITALIC
 * PLAIN

### Default Imports

The following packages are automatically imported in Views

 * javax.swing
 * javax.swing.event
 * javax.swing.table
 * javax.swing.text
 * javax.swing.tree
 * java.awt
 * java.awt.event

Watch out for usages of the type `List`, as it gets imported from two places
(`java.util.List` and `java.awt.List`). You must use the fully qualified class
name in order to avoid the wrong type being inferred by the compiler.

Configuration
-------------

### Checking EDT Violations

It's possible to check for EDT violations by specifying the following System
property: `griffon.swing.edt.violations.check`. For example, while invoking
`griffon run-app` like this

    griffon -Dgriffon.swing.edt.violations.check=true run-app

### EDT Hang Monitor

Sometimes an operation running inside the EDt may take more time that what it's
supposed to but it's hard to figure out where the problem lies exactly. The
Swing plugin enables an EDT hang monitor to be run as long as the following
System property is set: `griffon.swing.edt.hang.monitor`. The default timeout
is set to `1000`. Should you require a higher timeout then specify an integer
value (in ms) for `griffon.swing.edt.hang.monitor.timeout`. Lower values than
`1000` are not accepted.

Here's a sample invocation with these two properties set

    griffon -Dgriffon.swing.edt.hang.monitor=true -Dgriffon.swing.edt.hang.monitor.timeout=1500 run-app

**Note:** it's not recommended to enable either of these flags in production
mode. These checks should be performed during development and/or testing.

Tool Support
------------

### DSL Descriptors

This plugin provides DSL descriptors for Intellij IDEA and Eclipse (provided
you have the Groovy Eclipse plugin installed). These descriptors are found
inside the `griffon-swing-compile-x.y.z.jar`, with locations

 * dsdl/swing.dsld
 * gdsl/swing.gdsl

[1]: http://groovy.codehaus.org/Swing+Builder

