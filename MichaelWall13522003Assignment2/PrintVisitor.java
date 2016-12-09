public class PrintVisitor implements CCALParserVisitor {

    public Object visit(SimpleNode node, Object data) {

	       throw new RuntimeException("Visit SimpleNode");
    }

    public Object visit(ASTPROG node, Object data) {

        for(int i = 0; i < node.jjtGetNumChildren(); i++) {

            node.jjtGetChild(i).jjtAccept(this, data);
            System.out.println();
        }
        System.out.println();
    	return data;
    }

    public Object visit(ASTVAR_DECL node, Object data) {

        for(int i = 0; i < node.jjtGetNumChildren(); i+=2) {

            System.out.print("var ");
            node.jjtGetChild(i).jjtAccept(this, data);
            System.out.print(":");
            node.jjtGetChild(i+1).jjtAccept(this, data);
            System.out.println(";");
        }
    	return data;
    }

    public Object visit(ASTCONST_DECL node, Object data) {

        System.out.print("var ");
        node.jjtGetChild(0).jjtAccept(this, data);
        System.out.print(":");
        node.jjtGetChild(1).jjtAccept(this, data);

        System.out.println(";");
    	return data;
    }

    public Object visit(ASTARGSLIST node, Object data) {
        for(int i = 0; i < node.jjtGetNumChildren(); i++) {

            node.jjtGetChild(i).jjtAccept(this, data);
        }
        System.out.println(";");
        return data;
    }

    public Object visit(ASTPARAMLIST node, Object data) {
        System.out.print("(");
        for(int i = 0; i < node.jjtGetNumChildren(); i+=2) {

            node.jjtGetChild(i).jjtAccept(this, data);
            System.out.print(":");
            node.jjtGetChild(i+1).jjtAccept(this, data);
            if (node.jjtGetNumChildren() - i > 2) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
        return data;
    }

    public Object visit(ASTASSIGN node, Object data) {

        for(int i = 0; i < node.jjtGetNumChildren(); i+=2) {

            node.jjtGetChild(i).jjtAccept(this, data);
            System.out.print("=");
            node.jjtGetChild(i+1).jjtAccept(this, data);
        }
        System.out.println(";");
    	return data;
    }

    public Object visit(ASTBINOP node, Object data) {

        System.out.print(node.value);
    	return data;
    }

    public Object visit(ASTBOOLOP node, Object data) {

        System.out.print(node.value);
    	return data;
    }

    public Object visit(ASTBOOL node, Object data) {

    	System.out.print(node.value);
    	return data;
    }

    public Object visit(ASTNEGATIVE node, Object data) {

    	System.out.print(node.value);
        return data;
    }

    public Object visit(ASTCONDITION node, Object data) {

        for(int i = 0; i < node.jjtGetNumChildren(); i++) {

            node.jjtGetChild(i).jjtAccept(this, data);
        }
    	return(data);
    }

    public Object visit(ASTFUNC node, Object data) {

        node.jjtGetChild(0).jjtAccept(this, data);
        System.out.print(" ");
        node.jjtGetChild(1).jjtAccept(this, data);
        System.out.print(" ");

        for(int i = 2; i < node.jjtGetNumChildren(); i++) {

            System.out.print("  ");node.jjtGetChild(i).jjtAccept(this, data);
        }
    	return data;
    }

    public Object visit(ASTID node, Object data) {

    	System.out.print(node.value);
    	return data;
    }

    public Object visit(ASTNUM node, Object data) {

    	System.out.print(node.value);
    	return data;
    }

    public Object visit(ASTTYPE node, Object data) {

    	System.out.print(node.value);
    	return data;
    }

    public Object visit(ASTMAIN node, Object data) {

    	System.out.println("main {");
        for(int i = 0; i < node.jjtGetNumChildren(); i++) {

            System.out.print("  ");node.jjtGetChild(i).jjtAccept(this, data);
        }

        System.out.println("}");
    	return data;
    }
}
