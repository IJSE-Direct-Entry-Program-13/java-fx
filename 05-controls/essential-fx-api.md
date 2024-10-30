# Essential Java FX API

### Node API

```
getCursor(): Cursor
setCursor(Cursor value): void

getLayoutX(): double
getLayoutY(): double
setLayoutX(double value): void
setLayoutY(double value): void

getTranslateX(): double
getTranslateY(): double
setTranslateX(double value): void
setTranslateY(double value): void

getOpacity(): double
setOpacity(double value): void

getParent(): Parent

getRotate(): double
setRotate(double value): void

getRotationAxis(): Point3D
setRotationAxis(Point3D value): void

getScaleX(): double
setScaleX(double value): void

getScaleY(): double
setScaleY(double value): void

getScene(): Scene

getStyle(): String
setStyle(String value): void

getStyleClass(): ObservableList<String>

getUserData(): Object
setUserData(Object value): void

isDisable(): boolean
isDisabled(): boolean
setDisable(boolean value): void

isFocused(): boolean
isPressed(): boolean
isHover(): boolean
isFocusTraversable(): boolean
isFocusWithin(): boolean

isVisible(): boolean
setVisible(boolean value): void

toBack(): void
toFront(): void

startDragAndDrop(TransferMode... transferModes): Dragboard
startFullDrag(): void

isMouseTransparent(): boolean
setMouseTransparent(boolean value): void
```

### Parent API

```
getChildrenUnmodifibale(): ObservableList<Node>
```

### Region API

```
getHeight(): double
getMaxHeight(): double
getMinHeight(): double
getPrefHeight(): double

getWidth(): double
getMaxWidth(): double
getMinWidth(): double
getPrefWidth(): double

setHeight(double value): void
setMaxHeight(double value): void
setMinHeight(double): void
setPrefHeight(double): void

setWidth(double value): void
setMaxWidth(double value): void
setMinWidth(double value): void
setPrefWidth(double value): void

setMaxSize(double width, double height): void
setMinSize(double width, double height): void
setPrefSize(double width, double height): void

getBackground(): Background
getBorder(): Border
getPadding(): Insets

setBackground(Background value): void
setBorder(Border value): void
setPadding(Insets value): void
```

### Control API

```
getContextMenu(): ContextMenu
setContextMenu(ContextMenu value): void

getTooltip(): Tooltip
setTooltip(Tooltip value): void
```
