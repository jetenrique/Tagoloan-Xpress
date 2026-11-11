const assetPathPrefix = "https://www.figma.com/api/mcp/asset/b4d7e8ca-74ae-4c66-b5fc-663ab08b90a6";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconBike = `${assetPathPrefix}/9d05c.svg`;
const imgIconPhone = `${assetPathPrefix}/eede5.svg`;
const imgIconEye = `${assetPathPrefix}/eca05.svg`;
const imgIconShield = `${assetPathPrefix}/6f4c2.svg`;

export default function RiderLogin() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:1464" data-name="rider login">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="122:3" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="122:4" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="122:5" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="122:6">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="122:7" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="122:8" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="122:10" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="122:12" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="122:14" data-name="App bar">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="122:15" data-name="Back button">
            <div className="relative shrink-0 size-[18px]" data-node-id="122:16" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="content-stretch flex flex-[1_0_0] flex-col items-start min-w-px overflow-clip relative" data-node-id="122:18" data-name="Container">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] relative shrink-0 text-[#18181f] text-[18px] w-full" data-node-id="122:19">
              Rider portal
            </p>
          </div>
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[20px] items-start min-h-px overflow-clip px-[24px] py-[16px] relative w-full" data-node-id="122:21" data-name="Body">
          <div className="content-stretch flex flex-col gap-[8px] items-start overflow-clip relative shrink-0 w-full" data-node-id="122:22" data-name="Intro">
            <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[16px] shrink-0 size-[56px]" data-node-id="122:23" data-name="Container">
              <div className="relative shrink-0 size-[28px]" data-node-id="122:24" data-name="icon/bike">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBike} />
              </div>
            </div>
            <div className="h-[4px] relative shrink-0 w-full" data-node-id="122:29" data-name="Spacer" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[24px] w-[min-content]" data-node-id="122:30">
              Welcome back, rider
            </p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-full relative shrink-0 text-[#6b6b73] text-[14px] w-[min-content]" data-node-id="122:31">
              Log in to start accepting Pasugo requests.
            </p>
          </div>
          <div className="h-[4px] relative shrink-0 w-full" data-node-id="122:32" data-name="Spacer" />
          <div className="content-stretch flex flex-col gap-[6px] items-start overflow-clip relative shrink-0 w-full" data-node-id="122:33" data-name="Field – Mobile number">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] relative shrink-0 text-[#18181f] text-[13px] whitespace-nowrap" data-node-id="122:34">
              Mobile number
            </p>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[10px] h-[48px] items-center overflow-clip px-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="122:35" data-name="Input">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[15px]" data-node-id="122:36">
                0917 849 2011
              </p>
              <div className="relative shrink-0 size-[18px]" data-node-id="122:37" data-name="icon/phone">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPhone} />
              </div>
            </div>
          </div>
          <div className="content-stretch flex flex-col gap-[6px] items-start overflow-clip relative shrink-0 w-full" data-node-id="122:40" data-name="Field – Password">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] relative shrink-0 text-[#18181f] text-[13px] whitespace-nowrap" data-node-id="122:41">
              Password
            </p>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[10px] h-[48px] items-center overflow-clip px-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="122:42" data-name="Input">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[15px]" data-node-id="122:43">
                ••••••••••
              </p>
              <div className="relative shrink-0 size-[18px]" data-node-id="122:44" data-name="icon/eye">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconEye} />
              </div>
            </div>
          </div>
          <div className="content-stretch flex items-start justify-end overflow-clip relative shrink-0 w-full" data-node-id="122:47" data-name="Container">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b4e00] text-[13px] whitespace-nowrap" data-node-id="122:48">
              Forgot password?
            </p>
          </div>
          <a className="bg-[#febc20] content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="122:49" data-name="Button – Log in">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="122:50">
              Log in
            </p>
          </a>
          <div className="content-stretch flex gap-[8px] items-center justify-center overflow-clip relative shrink-0 w-full" data-node-id="122:52" data-name="Container">
            <div className="relative shrink-0 size-[14px]" data-node-id="122:53" data-name="icon/shield">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconShield} />
            </div>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="122:55">
              New accounts are activated after Admin approval
            </p>
          </div>
          <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="122:56" data-name="Flexible space" />
          <div className="content-stretch flex flex-col gap-[10px] items-center overflow-clip relative shrink-0 w-full" data-node-id="122:57" data-name="Register">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] whitespace-nowrap" data-node-id="122:58">
              New to Tagoloan Xpress?
            </p>
            <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[13px] relative rounded-[14px] shrink-0 w-full" data-node-id="122:59" data-name="Button – Apply as a rider">
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="122:60">
                Apply as a rider
              </p>
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}
