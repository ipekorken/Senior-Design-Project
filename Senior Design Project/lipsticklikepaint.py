import imutils
from pylab import *
from imutils import face_utils
import dlib
import cv2

def points():
    p = "shape_predictor_68_face_landmarks.dat"
    detector = dlib.get_frontal_face_detector()
    predictor = dlib.shape_predictor(p)

    mouth = (48, 68)
    color = (0, 0, 255)

    image = cv2.imread('Input.jpg')
    image = imutils.resize(image, width=500)
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    rects = detector(gray, 0)

    for (i, rect) in enumerate(rects):

        shape = predictor(gray, rect)
        shape = face_utils.shape_to_np(shape)

        i = 48;
        j = 69;
        clone = image.copy()
        f = open("paintpoint.txt", "w+")

        for (x, y) in shape[i:j]:
            f.write(str(x) + " " + str(y) + "\n")
            cv2.circle(clone, (x, y), 1, (0, 0, 255), -5)
           # cv2.fillPoly(clone, (x,y), color=[0, 0, 255])

        pts = shape[i:j]
        b = []
        e = []
        m = int(len(pts) / 2)
        z = 0
        for a in pts:
            if (z == m):
                break
            b.append(a)
            z+=1
        for i in range(m, len(pts)):
            e.append(pts[i])
        for l in range(0, len(pts)):
            ptA = tuple(pts[l - 1])
            ptB = tuple(pts[l])
            cv2.line(clone, ptA, ptB, color, 2)
            hull = cv2.convexHull(pts)
            cv2.drawContours(clone, [hull], -1, color, -1)
        f.close()

        cv2.imshow("Image", clone)
        cv2.waitKey(0)

points()



