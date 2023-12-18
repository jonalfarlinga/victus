# import the pygame module, so you can use it
import pygame
import os
import sys


# (if you import this as a module then nothing is executed)
if __name__ == "__main__":

    # initialize the pygame module
    pygame.init()

    # Setting up FPS
    FPS = 60
    FramePerSec = pygame.time.Clock()

    # Setting up colors
    BLUE = (50, 50, 255)

    # load and set the logo
    # pygame.display.set_icon()
    pygame.display.set_caption("My Cafe")

    # Setting up Fonts
    font = pygame.font.SysFont("Broadway", 60)
    welcome = font.render("Welcome", True, BLUE)

    # load the images

    # create a surface and populate it
    screen = pygame.display.set_mode((1000, 665))
    screen.blit(welcome, (500, 125))

    pygame.display.flip()

    # main loop
    while True:
        # event handling, gets all event from the event queue
        for event in pygame.event.get():
            # only do something if the event is of type QUIT
            if event.type == pygame.QUIT:
                # change the value to False, to exit the main loop
                pygame.quit()
                sys.exit()
            if event.type == pygame.MOUSEBUTTONDOWN:
                pos = pygame.mouse.get_pos()
                pygame.display.update()
        FramePerSec.tick(FPS)
