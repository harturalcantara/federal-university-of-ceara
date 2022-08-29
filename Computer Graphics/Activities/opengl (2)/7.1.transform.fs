#version 330 core
out vec4 FragColor;

in vec3 ourColor;
uniform vec3 objectColor;

void main()
{
    if (objectColor.x == -1.0f)
	   FragColor = vec4(ourColor, 1.0f);
    else
       FragColor = vec4(objectColor, 0.5f);
}
