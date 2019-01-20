import numpy
from pylab import *

import numpy as np
import matplotlib.pyplot as plt
import cv2

def draw_circle(event,x,y,flags,param):

#in draw_circle function, we selected points by mouse.
    global mouseX,mouseY
    if event == cv2.EVENT_LBUTTONDBLCLK:
        cv2.circle(img,(x,y),1,(255,0,0),-1)
        mouseX,mouseY = x,y
img = (cv2.imread("Input.jpg"))
cv2.namedWindow('image')
cv2.setMouseCallback('image',draw_circle)



while(1):
    cv2.imshow('image',img)
    k = cv2.waitKey(20) & 0xFF
    if k == 27:
        break
    elif k == ord('a'):
        print (mouseX,mouseY)